/**
 * Created by joe on 16/3/31.
 */
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.autoscaling.AmazonAutoScaling;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;

import java.util.LinkedList;
import java.util.List;

public class LaunchConfiguration {
    public static void main(String[] args) {
        try {

            String CredentialLocation = args[0];
            String launchConfigName = args[1];

            /**
             * the connection steps
             */

            AWSCredentials credentials = null;
            credentials = new ProfileCredentialsProvider(CredentialLocation, "default").getCredentials();
            Helper.writeResponse("successfully connect with aws");

            /**
             * the injection fault steps
             */
            AmazonAutoScaling autoScaling = new AmazonAutoScalingClient(credentials);

            //Launch configuration
            String instanceType = "m4.large";
            String imageId = "ami-fce3c696";
            String keyPair = "hahaha";
            String securityGroup = "sg-29e8a351";
            String userData = "";
            CreateLaunchConfigurationRequest launchConfigRequest = new CreateLaunchConfigurationRequest()
                    .withLaunchConfigurationName(launchConfigName)
                    .withInstanceType(instanceType).withImageId(imageId)
                    .withKeyName(keyPair).withSecurityGroups(securityGroup)
                    .withUserData(userData);
            autoScaling.createLaunchConfiguration(launchConfigRequest);
            Helper.writeResponse("fault has been injected, waiting for monitoring");

            /**
             * the monitor steps
             * wait a little second before start
             */
            Thread.sleep(3000);
            AmazonAutoScaling autoTester = new AmazonAutoScalingClient(credentials);
            DescribeLaunchConfigurationsResult launchConfigurations = autoTester.describeLaunchConfigurations();

            List<com.amazonaws.services.autoscaling.model.LaunchConfiguration> lcs = new LinkedList<>();

            lcs.addAll(launchConfigurations.getLaunchConfigurations());


            boolean isSuccess = false;
            for (int i = 0; i < lcs.size(); i++) {
                if(lcs.get(i).getLaunchConfigurationName().compareTo(launchConfigName) == 0) {
                    isSuccess = true;
                }
            }

            if (isSuccess == true) {
                Helper.writeResponse("successfully create launchconfiguration with name" + args[1] + "and the result has been monitored");
                Helper.SuccessComplete();
            } else {
                Helper.writeResponse("monitor doesn't found the launchConfiguration with indicated name");
                Helper.FailComplete();
            }

        } catch (AmazonServiceException ase) {
            Helper.writeResponse(ase);
            Helper.FailComplete();
        } catch (AmazonClientException ace) {
            Helper.writeResponse(ace);
            Helper.FailComplete();
        } catch (Exception e){
            Helper.writeResponse(e);
            Helper.FailComplete();
        }
    }
}
