// <auto-generated/>
#pragma warning disable 1591
#pragma warning disable 0414
#pragma warning disable 0649
#pragma warning disable 0169

namespace WebApplication.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.AspNetCore.Components.Web.Virtualization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 10 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/joblisting/create")]
    public partial class CreateJobListing : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 91 "C:\Users\klavs\OneDrive - ViaUC\Semester3\SEP\code\Tier1\WebApplication\WebApplication\Pages\CreateJobListing.razor"
           
        private JobListing jobListing = new JobListing();
        private List<string> jobRequirements = new List<string>();
        private List<string> jobPrivilleges = new List<string>();
        private DateTime ApplicationDate = DateTime.Now;


        protected override async Task OnInitializedAsync()
        {
            jobRequirements.Add(null);
            jobPrivilleges.Add(null);
        }

        private async void CreateNewJobListing()
        {

            foreach (var jr in jobRequirements)
            {
                if (jr == null) jobRequirements.Remove(jr);
            }

            foreach (var jr in jobPrivilleges)
            {
                if (jr == null) jobPrivilleges.Remove(jr);
            }

            jobListing.ApplicationDeadline = ApplicationDate.ToString("dd/MM/yyyy");
            jobListing.JobRequirments = jobRequirements;
            jobListing.JobPrivilleges = jobPrivilleges;
            await JobListingData.CreateJobListing(jobListing);
            IList<JobListing> jbs = await JobListingData.GetJobListings();
            Console.WriteLine(jbs.Count);
            NavigationManager.NavigateTo("/job-listings");
        }

        private void SetJobType(ChangeEventArgs args)
        {
            jobListing.JobType = args.Value.ToString();
        }

        private void AddJobReq()
        {
            if (jobRequirements.Count < 5)
            jobRequirements.Add(null);
        }

        private void AddJobPrivilege()
        {
            if (jobPrivilleges.Count < 5)
                jobPrivilleges.Add(null);
        }
    

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJobListingData JobListingData { get; set; }
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private NavigationManager NavigationManager { get; set; }
    }
}
#pragma warning restore 1591
